import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;


public class Cube implements Object3D {
	
	private float x, y, z, l; // Position et taille (taille : l)
	private float tx, ty, tz; // Angle
	private float speedx = 0;
	private float speedy = 0;
	private float speedz = 0;
	
	public Cube(float x, float y, float z, float l, float tx, float ty, float tz) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.l = l;
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
	}
	
	public void render(GLAutoDrawable drawable) {
		
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glLoadIdentity();
		
		gl.glPushMatrix();
		
		gl.glTranslatef(x, y, z);
		
		gl.glRotatef(speedx, 1.0f, 0.0f, 0.0f);
		gl.glRotatef(speedy, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(speedz, 0.0f, 0.0f, 1.0f);
		
		gl.glBegin(gl.GL_QUADS);

			// FRONT
			gl.glColor3f( 1.0f, 0.0f, 0.0f); //face rouge
			gl.glVertex3f( -l, -l, -l);
			gl.glVertex3f( l, -l, -l);
			gl.glVertex3f( l, l, -l);
			gl.glVertex3f( -l, l, -l);
			
			
			// RIGHT
			gl.glColor3f( 0.0f, 1.0f, 0.0f); //face verte
			gl.glVertex3f( l, -l, -l);
			gl.glVertex3f( l, -l, l);
			gl.glVertex3f( l, l, l);
			gl.glVertex3f( l, l, -l);
			                                                                                                    
			// BACK
			gl.glColor3f( 1.0f, 0.0f, 0.0f); //face rouge
			gl.glVertex3f( -l, -l, l);
			gl.glVertex3f( l, -l, l);
			gl.glVertex3f( l, l, l);
			gl.glVertex3f( -l, l, l);
			
			// LEFT
			gl.glColor3f( 0.0f, 1.0f, 0.0f); //face verte
			gl.glVertex3f( -l, -l, l);
			gl.glVertex3f( -l, -l, -l);
			gl.glVertex3f( -l, l, -l);
			gl.glVertex3f( -l, l, l);
			
			// TOP
			gl.glColor3f( 0.0f, 0.0f, 1.0f); //face bleue
			gl.glVertex3f( -l, l, -l);
			gl.glVertex3f( l, l, -l);
			gl.glVertex3f( l, l, l);
			gl.glVertex3f( -l, l, l);
			
			// BOTTOM
			gl.glColor3f( 0.0f, 0.0f, 1.0f); //face bleue
			gl.glVertex3f( -l, -l, -l);
			gl.glVertex3f( l, -l, -l);
			gl.glVertex3f( l, -l, l);
			gl.glVertex3f( -l, -l, l);

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
