package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Peacock;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceLantern;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Others.Mental.Fascination;
import TheSecretHistories.Utils.StringUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ThePeacockDoor extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(ThePeacockDoor.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            // TODO 伐诃语
            new InfluenceLantern().DoUpgrade(3),
            new FragmentSecretHistories().DoUpgrade(4),
            new Fascination(),
    };

    private final AbstractCard chosenCard;

    public ThePeacockDoor() {
        super(ID, IMG_NAME, CARDS);

        int idx = MathUtils.random(CARDS.length - 1);
        this.chosenCard = CARDS[idx].makeCopy();
    }

    @Override
    public void update() {
        super.update();
        if (this.hb.hovered) {
            this.cardsToPreview = chosenCard;
        }
    }

    @Override
    public void onChoseThisOption() {
        AbstractDungeon.actionManager.addToBottom(
                new MakeTempCardInHandAction(chosenCard.makeStatEquivalentCopy())
        );
    }

}
