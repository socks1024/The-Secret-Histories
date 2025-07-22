package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Wood;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceMoth;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Others.Rumour;
import TheSecretHistories.Utils.StringUtils;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheTempleOfTheWheel extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheTempleOfTheWheel.class.getSimpleName());

    private static final String IMG_NAME = "waywood";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceKnock(),
            new InfluenceHeart(),
            new FragmentSecretHistories().DoUpgrade(1),
            new Rumour(),
    };

    public TheTempleOfTheWheel() {
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

