package TheSecretHistories.Content.Powers.Template;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public abstract class TemplateCustomPower extends AbstractPower{

    protected final PowerStrings powerStrings;

    public TemplateCustomPower(String id, String img, AbstractCreature owner, int amount)
    {
        this.ID = id;

        SetPowerImg(this, img);

        this.powerStrings = CardCrawlGame.languagePack.getPowerStrings(CutNumber(id));
        this.name = powerStrings.NAME;

        this.owner = owner;
        this.amount = amount;

        this.updateDescription();
    }

    public void updateDescription(){
        String newDescription = powerStrings.DESCRIPTIONS[0];

        if (newDescription.contains("%d")) {
            this.description = String.format(newDescription, amount);
        } else {
            this.description = String.format(newDescription);
        }
    }

    protected void SetPowerImg(AbstractPower power, String img)
    {
        String path128 = MakePowerImgPath128(img);
        String path48 = MakePowerImgPath48(img);
        power.region128 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path128),0,0,128,128);
        power.region48 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path48),0,0,48,48);
    }

    protected static String MakePowerImgPath128(String img){
        String s1 = "TheSecretHistories/img/powers/";
        String s2 = img + "128.png";

        return s1+s2;
    }

    protected static String MakePowerImgPath48(String img){
        String s1 = "TheSecretHistories/img/powers/";
        String s2 = img + "48.png";

        return s1+s2;
    }

    protected static String CutNumber(String input) {
        return input.replaceAll("\\d", "");
    }
}
