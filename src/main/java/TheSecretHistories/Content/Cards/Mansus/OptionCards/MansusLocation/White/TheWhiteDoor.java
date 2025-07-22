package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.White;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceMoth;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceWinter;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Others.Mental.Restlessness;
import TheSecretHistories.Utils.StringUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class TheWhiteDoor extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheWhiteDoor.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceWinter().DoUpgrade(1),
            new FragmentSecretHistories().DoUpgrade(1),
            new Restlessness(),
    };

    private final AbstractCard chosenCard;

    public TheWhiteDoor() {
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

