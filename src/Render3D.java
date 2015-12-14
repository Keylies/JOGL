import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;


public class Render3D implements GLEventListener {
	
	private ArrayList<Object3D> objects = new ArrayList<Object3D>();
	
	private Object3D cube1;
	private Object3D cube2;
	private Object3D cube3;
	
	File fileImg1;
	File fileImg2;
	File fileImg3;
	Texture t1 = null;
	Texture t2 = null;
	Texture t3 = null;
	int texture1;
	int texture2;
	int texture3;
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		
		update();
		render(drawable);
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glShadeModel(gl.GL_LINE_SMOOTH);
		gl.glClearDepth(1.0f);
		gl.glEnable(gl.GL_DEPTH_TEST);
		gl.glDepthFunc(gl.GL_LEQUAL);
		gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);

		gl.glMatrixMode(gl.GL_MODELVIEW);
		
		gl.glEnable(gl.GL_TEXTURE_2D);
		
		try {
			fileImg1 = new File("t1.jpg");
			fileImg2 = new File("t2.jpg");
			fileImg3 = new File("t3.jpg");
			t1 = TextureIO.newTexture(fileImg1, true);
			t2 = TextureIO.newTexture(fileImg2, true);
			t3 = TextureIO.newTexture(fileImg3, true);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		texture1 = t1.getTextureObject(gl);
		texture2 = t2.getTextureObject(gl);
		texture3 = t3.getTextureObject(gl);
		
		cube1 = new Cube(0.0f, 0.0f, -8.0f, 0.5f, 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, texture1);
		cube2 = new Cube(0.0f, 1.0f, -8.0f, 0.2f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, texture2);
		cube3 = new Cube(0.0f, 0.0f, -8.0f, 0.2f, 0.0f, 0.0f, 0.5f, 2.0f, 0.0f, 0.0f, texture3);
		
		objects.add(cube1);
		objects.add(cube2);
		objects.add(cube3);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glViewport(0, 0, w, h);
		gl.glMatrixMode(gl.GL_PROJECTION);
		gl.glLoadIdentity();
		
		GLU glu = new GLU();
		glu.gluPerspective(45.0f, (float)w/(float)h, 0.1f, 100.0f);
		gl.glMatrixMode(gl.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
	
	private void update() {
		for ( Object3D object : objects)
			object.update();
	}
	
	private void render(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		for ( Object3D object : objects)
			object.render(drawable);
	}

}
