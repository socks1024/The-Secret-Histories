package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Spider;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceForge;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceLantern;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.Forge.IngredientForgeF;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Others.Favour;
import TheSecretHistories.Utils.StringUtils;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheMalleary extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheMalleary.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceForge().DoUpgrade(3),
            new InfluenceLantern().DoUpgrade(2),
            new IngredientForgeF(),
            new FragmentSecretHistories().DoUpgrade(4),
            new Favour(),
    };

    public TheMalleary() {
        super(ID, IMG_NAME, CARDS);
    }

    private float rotationTimer = 0f;
    private int previewIndex = 0;

    @Override
    public void update() {
        super.update();
        if (this.hb.hovered) {
            if (this.rotationTimer <= 0f) {
                this.rotationTimer = 1f;
                this.cardsToPreview = CARDS[previewIndex].makeCopy();
                previewIndex = (previewIndex + 1) % CARDS.length;
            } else {
                this.rotationTimer -= Gdx.graphics.getDeltaTime();
            }
        }
    }
}
