package prj.achocolate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

//import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Ace {
	
	public static FPSLogger fps = new FPSLogger();
	
	public static void fillGroup(Group group, Actor ... actors) {
		for(Actor actor : actors){
			group.addActor(actor);
		}
		
	}
	
	public void fillSpriteCache(SpriteCache spriteCache, Texture ...textures) {
		for(Texture texture : textures){
			spriteCache.add(texture, 0, 0);
		}
		
	}
	
	
	
	public static void fillActors(Stage stage, Actor ... actors) {
		for(Actor actor : actors){
			stage.addActor(actor);
		}
		
	}
	
	
	public void dispose(Texture ... textures) {
		for(Texture texture : textures){
			texture.dispose();
		}
		Gdx.app.log("INFO", "message");
	}
	
	public void dispose(TextureRegion ... textures) {
		for(TextureRegion texture : textures){
			texture.getTexture().dispose();
		}
	}
	
	public static void prepareScreen(Camera camera, SpriteBatch batch) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
	}
	
	public static void renderScreen(Stage stage, float delta) {
		Gdx.gl.glClearColor(0,0,0,1); //sets clear color to black
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clear the batch
        stage.act(delta); //update all actors
        stage.draw();
	}
	
	public static OrthographicCamera ortCamera(float width, float height) {
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, width, height);
		return camera;
	}
	
	public static void exit() {
		Gdx.app.log("INFO", "Exit");
		Gdx.app.exit();
	}
	
	public static void main(String[] args) {
		
	}
	
	
}
