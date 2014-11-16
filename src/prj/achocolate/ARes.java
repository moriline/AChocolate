package prj.achocolate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ARes {
	
	public static AssetManager manager = new AssetManager();
	
	public static float ratio;
	
	public Group group() {
		return new Group();
	}

	/*public static Stage stage() {
		Stage stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		return stage;
	}*/
	
	public static Stage stage(Viewport viewport) {
		Stage stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage);
		return stage;
	}
	
	/**
	 * Get stage.
	 * @return
	 */
	public static Stage stage() {
		return stage(new ScreenViewport());
	}
	
	/**
	 * Get spriteBatch.
	 * @return
	 */
	public static SpriteBatch batch() {
		return new SpriteBatch();
	}
	
	/**
	 * Get font by filename.
	 * "font.fnt"
	 * @param fileName
	 * @return
	 */
	public BitmapFont font(String fileName) {
		return new BitmapFont(Gdx.files.internal(fileName), false);
	}
	
	/**
	 * Get music by filename.
	 * "jump.mp3"
	 * @param fileName
	 * @return
	 */
	public Music music(String fileName) {
		Music music = Gdx.audio.newMusic(Gdx.files.internal(fileName));
		
		return music;
	}
	
	/**
	 * Get sound by filename.
	 * "jump.wav"
	 * @param fileName
	 * @return
	 */
	public Sound sound(String fileName) {
		return Gdx.audio.newSound(Gdx.files.internal(fileName));
	}
	
	/**
	 * for save changes call: prefs.flush();
	 * @param name
	 * @return
	 */
	public Preferences prefs(String name) {
		Preferences prefs = Gdx.app.getPreferences(name);
		return prefs;
	}
	
	public static Texture texture(String fileName) {
		return new Texture(Gdx.files.internal(fileName));
	}
	
	public static Texture texture(Pixmap pixmap) {
		return new Texture(pixmap);
	}
	
	public static Pixmap pixmap(String fileName) {
		return new Pixmap(Gdx.files.internal(fileName));
	}
	
	
	/**
	 * "uiskin.json"
	 * @param fileName
	 * @return Skin
	 */
	public static Skin skin(String fileName) {
		return new Skin(Gdx.files.internal(fileName));
	}
	/** "atlasname.pack"
	 * @param fileName
	 * @return
	 */
	public static TextureAtlas atlas(String fileName) {
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(fileName));
		return atlas;
	}
	
	public static TextureRegion region(TextureAtlas atlas, String regionNumber) {
		AtlasRegion region = atlas.findRegion(regionNumber);
		
		return new TextureRegion(region);
	}
	
	public static TextureRegion region(String fileName) {
		Texture texture = texture(fileName);
		return new TextureRegion(texture, texture.getWidth(), texture.getHeight());
	}
	
	public static Image img(String fileName) {
		return new Image(texture(fileName));
	}
	
	public static Sprite sprite(Texture texture) {
		return new Sprite(texture);
	}
	
	public static Sprite sprite(TextureRegion texture) {
		return new Sprite(texture);
	}
	
	public static Label label(String text, Skin skin) {
		Label label = new Label(text, skin);
		
		return label;
	}
	
	public static TextButton txtBtn(String text, Skin skin, String styleName) {
		TextButton button = new TextButton(text, skin, styleName);
		return button;
	}
}
