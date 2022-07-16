#version 330

in vec2 fragTexCoord;
in vec4 fragColor;

uniform sampler2D texture0;
uniform vec4 colDiffuse;

uniform float iTime;

out vec4 finalColor;

void main() {
      vec2 iResolution = vec2(320, 180);
      vec2 uv =  (2.0 * gl_FragCoord.xy - iResolution.xy) / min(iResolution.x, iResolution.y);
   
      for(float i = 1.0; i < 8.0; i++){
            uv.y += i * 0.2 / i * sin(uv.x * i * i + iTime * 2) * sin(uv.y * i * i + iTime * 2);
      }
      
      vec3 col;
      col.r  = uv.y;
      col.g = uv.y;
      col.b = uv.y;

      col *= 0.6;

      col += 0.4 * sin(iTime * 2) * sin(uv.x * iTime * 2) * sin(uv.y * iTime * 2);

      col = mix(col, vec3(0.0), 0.8);
      
      finalColor = vec4(col,1.0);
}