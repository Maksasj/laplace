#version 330

// Input vertex attributes (from vertex shader)
in vec2 fragTexCoord;
in vec4 fragColor;

// Input uniform values
uniform sampler2D texture0;
uniform vec4 colDiffuse;

uniform float rBorder;

// Output fragment color
out vec4 finalColor;

vec2 resolution = vec2(1280, 720);
// NOTE: Add here your custom variables

float rect( vec2 p, vec2 b)
{
	vec2 v = abs(p) - b;
	float d = length(max(v,0.0));
	return pow(d, 1.9);
}

vec3 drawRedBorder(vec3 col, float size) {
    vec2 unipos = (gl_FragCoord.xy / resolution);
    vec2 pos = unipos*4.0-1.0;
      //pos.x *= resolution.x / resolution.y;	
    float d1 = rect(pos - vec2(1.0,1), vec2(0.5,1)); 
    vec3 clr1 = vec3(1.0,0.3,0.2) *d1; 
      
    return col + vec3( clr1*size);
}

vec3 drawBorder(vec3 col, float size) {
    vec2 unipos = (gl_FragCoord.xy / resolution);
    vec2 pos = unipos*4.0-1.0;
      //pos.x *= resolution.x / resolution.y;	
    float d1 = rect(pos - vec2(1.0, 1), vec2(0.5,1)); 
    vec3 clr1 = vec3(0.6, 0.6, 0.6) *d1; 
      
    return col - vec3( clr1*size);
}

void main()
{
    // Texel color fetching from texture sampler
    vec4 texelColor = texture(texture0, fragTexCoord);
    //texelColor /= 3.0; 

    vec3 rgb = drawBorder(texelColor.rgb, 0.3);
    rgb = drawRedBorder(rgb, rBorder);
    // NOTE: Implement here your fragment shader code
    finalColor = vec4(rgb , 1.0);
    //finalColor = texelColor*colDiffuse;
}
