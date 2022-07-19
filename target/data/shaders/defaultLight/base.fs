#version 330

// Input vertex attributes (from vertex shader)
in vec2 fragTexCoord;
in vec4 fragColor;
in vec3 fragPosition;
in vec3 fragNormal;

// Input uniform values
uniform sampler2D texture0;
uniform vec4 colDiffuse;
uniform float playertint;
uniform vec3 viewPos;

// Output fragment color
out vec4 finalColor;

// NOTE: Add here your custom variables

struct Light {
    int enabled;
    int type;
    vec3 position;
    vec3 target;
    vec4 color;
};

#define     MAX_LIGHTS              4
#define     LIGHT_DIRECTIONAL       0
#define     LIGHT_POINT             1

void main() {
    vec4 texelColor = texture(texture0, fragTexCoord);
    vec3 lightDot = vec3(0.0);
    vec3 normal = normalize(fragNormal);
    vec3 viewD = normalize(viewPos - fragPosition);
    vec3 specular = vec3(0.0);

    float ambientLight = 0.8;

    Light test = Light(1, LIGHT_DIRECTIONAL, viewPos + vec3(5.0, 1.0, 5.0), vec3(5.0, 0.0, 5.0), vec4(1.0, 0.7, 0.3, 1.0));
    // NOTE: Implement here your fragment shader code

    for (int i = 0; i < 1; i++)
    {
        if (test.enabled == 1)
        {
            vec3 light = vec3(0.0);

            if (test.type == LIGHT_DIRECTIONAL) light = -normalize(test.target - test.position);
            if (test.type == LIGHT_POINT) light = normalize(test.position - fragPosition);

            float NdotL = max(dot(normal, light), 0.0);
            lightDot += test.color.rgb*NdotL;

            float specCo = 0.0;
            if (NdotL > 0.0) specCo = pow(max(0.0, dot(viewD, reflect(-(light), normal))), 16.0); // Shine: 16.0
            specular += specCo;
        }
    }

    finalColor = (texelColor*((colDiffuse + vec4(specular,1))*vec4(lightDot, 1.0)));
    finalColor += texelColor*colDiffuse*ambientLight;
    
    float fogDensity = 0.06;

    float dist = length(viewPos - fragPosition);
    const vec4 fogColor = vec4(0.1, 0.1, 0.1, 1.0);
    float fogFactor = 1.0/exp((dist*fogDensity)*(dist*fogDensity));
    fogFactor = clamp(fogFactor, 0.0, 1.0);

    finalColor = mix(fogColor, finalColor, fogFactor);
}
