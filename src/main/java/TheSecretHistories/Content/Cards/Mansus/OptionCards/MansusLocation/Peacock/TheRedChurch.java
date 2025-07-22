package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceLantern;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.Grail.IngredientGrailD;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Others.Favour;
import TheSecretHistories.Content.Cards.Others.Mental.Fascination;
import TheSecretHistories.Utils.StringUtils;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheRedChurch extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheRedChurch.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceGrail().DoUpgrade(3),
            new IngredientGrailD(),
            new FragmentSecretHistories().DoUpgrade(5),
            new Favour(),
            new Fascination(),
    };

    public TheRedChurch() {
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
                this.cardsToPreview = CARDS[previewIndex].makeStatEquivalentCopy();
                previewIndex = (previewIndex + 1) % CARDS.length;
            } else {
                this.rotationTimer -= Gdx.graphics.getDeltaTime();
            }
        }
    }
}
