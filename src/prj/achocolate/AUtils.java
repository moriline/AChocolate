package prj.achocolate;

import java.nio.ByteBuffer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Filter;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Vector3;

public class AUtils {

	public static TextureRegion [] transformTo1D(TextureRegion [][] regions, int cols, int rows) {
		TextureRegion [] result = new TextureRegion[cols * rows];
		int index = 0;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				result[index++] = regions[i][j];
			}
		}
		return result;
	}
	
	/*
	 * "images/atlas.png"
	 */
	public static java.util.List<TextureRegion> splitRegions(String fileName, int count) {
		java.util.List<TextureRegion> textureRegions = new java.util.ArrayList<TextureRegion>();
		Texture texture = new Texture(Gdx.files.internal(fileName));
		TextureRegion tmp[][] = TextureRegion.split(texture,
				texture.getWidth() / count, texture.getHeight() / count);
		for(int row=0; row < tmp.length; row++){
			 for (int col=0; col < tmp[row].length; col++){
				 textureRegions.add(tmp[row][col]);
			 }
		}
		return textureRegions;
	}
	
	public TextureRegion [][] splitRegions(String fileName, int cols, int rows) {
		Texture texture = new Texture(Gdx.files.internal(fileName));
		TextureRegion [][] result = TextureRegion.split(texture, texture.getWidth()/cols, texture.getHeight()/rows);
		return result;
	}
	
	public static void test() {
		FileHandle handle = Gdx.files.internal("data/myfile.txt");
		Pixmap pixmap = new Pixmap(handle);
		
		PixmapIO.writeCIM(handle, pixmap);
		
	}

	/**
	 * Getting world coordinates out of screen coordinates
	 * @param camera
	 * @param x
	 * @param y
	 * @return
	 */
	public static Vector3 getCoord(Camera camera, int x, int y) {
		Vector3 worldCoordinates = new Vector3(x, y, 0);
		camera.unproject(worldCoordinates);
		return worldCoordinates;
	}

	/**
	 * Check is support "Power of 2".
	 * @return
	 */
	public static boolean isNPOT() {
		return Gdx.graphics.supportsExtension("GL_OES_texture_npot") 
                || Gdx.graphics.supportsExtension("GL_ARB_texture_non_power_of_two");
	}
	
	public static Pixmap resize(Pixmap pixmap, float ratio) {
		Pixmap thumb = new Pixmap((int)(pixmap.getWidth() * ratio), (int)(pixmap.getHeight() * ratio), pixmap.getFormat());
		Pixmap.setFilter(Filter.BiLinear);
		thumb.drawPixmap(pixmap, 0, 0, pixmap.getWidth(), pixmap.getHeight(), 0, 0, thumb.getWidth(), thumb.getHeight());
		
		return thumb;
	}
}
