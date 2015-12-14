import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;


public class Cube implements Object3D {
	
	private float x, y, z, l;
	private float tx, ty, tz;
	private float speedx = 0;
	private float speedy = 0;
	private float speedz = 0;
	private float orbx, orby, orbz;
	private int texture;
	
	public Cube(float x, float y, float z, float l, float tx, float ty, float tz, float ox, float oy, float oz, int t) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.l = l;
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		orbx = ox;
		orby = oy;
		orbz = oz;
		texture = t;
	}
	
	public void render(GLAutoDrawable drawable) {
		
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glPushMatrix();
		
			gl.glTranslatef(x, y, z);
			
			gl.glRotatef(speedx, 1.0f, 0.0f, 0.0f);
			gl.glRotatef(speedy, 0.0f, 1.0f, 0.0f);
			gl.glRotatef(speedz, 0.0f, 0.0f, 1.0f);
				
			gl.glTranslatef(orbx, orby, orbz);
			
			gl.glBindTexture(gl.GL_TEXTURE_2D, texture);
	
			gl.glBegin(gl.GL_QUADS);

				// FRONT
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( -l, -l, -l);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( l, -l, -l);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( l, l, -l);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( -l, l, -l);
				
				// RIGHT
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( l, -l, -l);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( l, -l, l);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( l, l, l);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( l, l, -l);
				                                                                                                    
				// BACK
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( -l, -l, l);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( l, -l, l);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( l, l, l);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( -l, l, l);
				
				// LEFT
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( -l, -l, l);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( -l, -l, -l);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( -l, l, -l);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( -l, l, l);
				
				// TOP
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( -l, l, -l);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( l, l, -l);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( l, l, l);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( -l, l, l);
				
				// BOTTOM
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( -l, -l, -l);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( l, -l, -l);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( l, -l, l);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( -l, -l, l);
	
			gl.glEnd();
		
		gl.glPopMatrix();
		
	}

	@Override
	public void update() {
		
		speedx += tx;
		speedy += ty;
		speedz += tz;
	}
}
