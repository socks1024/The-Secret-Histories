package TheSecretHistories.Utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.util.HashMap;
import java.util.logging.Logger;

public class TextureLoader {
    private static HashMap<String, Texture> textures = new HashMap<>();

    public static Texture getTexture(String textureString) {
        if (textures.get(textureString) == null)
            try {
                loadTexture(textureString);
            } catch (GdxRuntimeException e) {
                return null;
            }
        return textures.get(textureString);
    }

    private static void loadTexture(String textureString) throws GdxRuntimeException {
        Texture texture = new Texture(textureString);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textures.put(textureString, texture);
    }
}
