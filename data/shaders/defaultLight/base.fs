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

uniform float lightCount;
uniform vec3 lightPos[16];
uniform vec3 lightColor[16];

out vec4 finalColor;

float lightStrength(int i) {
    return (1.0 / length(lightPos[i] - fragPosition) * 8);
}

void main() {
    vec4 texelColor = texture(texture0, fragTexCoord);
    vec3 lightDot = vec3(0.0);
    vec3 normal = normalize(fragNormal);
    vec3 viewD = normalize(viewPos - fragPosition);
    vec3 specular = vec3(0.0);

    float ambientLight = 0.5;

    for (int i = 0; i < lightCount; i++) {
        vec3 Llight = normalize(lightPos[i] - fragPosition);

        float NdotL = max(dot(normal, Llight), 0.0);
        lightDot += (lightColor[i].rgb*NdotL) * lightStrength(i);

        //float specCo = 0.0;
        //if (NdotL > 0.0) specCo = pow(max(0.0, dot(viewD, reflect(-(Llight), normal))), 16.0); // Shine: 16.0
        //specular += specCo;
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
