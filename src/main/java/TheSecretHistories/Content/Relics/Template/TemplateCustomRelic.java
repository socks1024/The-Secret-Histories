package TheSecretHistories.Content.Relics.Template;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.helpers.ImageMaster;

public abstract class TemplateCustomRelic extends CustomRelic {

    public TemplateCustomRelic(String id, String name, RelicTier tier, LandingSound sfx) {
        super(id, LoadRelicTex(name), tier, sfx);
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    protected static String MakeRelicImgPath(String name) {
        return "TheSecretHistories/img/relics/" + name + ".png";
    }

    protected static Texture LoadRelicTex(String name) {
        return ImageMaster.loadImage(MakeRelicImgPath(name));
    }
}
