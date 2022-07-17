#version 330

// Input vertex attributes (from vertex shader)
in vec2 fragTexCoord;
in vec4 fragColor;
in vec3 fragPosition;
in vec3 fragNormal;

// Input uniform values
uniform sampler2D texture0;
uniform vec4 colDiffuse;

// Output fragment color
out vec4 finalColor;

// NOTE: Add here your custom variables


void main()
{
    // Texel color fetching from texture sampler
    vec4 texelColor = texture(texture0, fragTexCoord)*colDiffuse*fragColor;

    // NOTE: Implement here your fragment shader code


    vec3 viewPos = vec3(0.0);

    float dist = length(viewPos - fragPosition);
    const vec4 fogColor = vec4(0.5, 0.5, 0.5, 1.0);
    const float fogDensity = 0.16;

    float fogFactor = 1.0/exp((dist*fogDensity)*(dist*fogDensity));
    fogFactor = clamp(fogFactor, 0.0, 1.0);

    finalColor = mix(fogColor, finalColor, fogFactor);

    finalColor = texelColor*colDiffuse*vec4(0.2, 0.2, 0.2, 1.0);
}
