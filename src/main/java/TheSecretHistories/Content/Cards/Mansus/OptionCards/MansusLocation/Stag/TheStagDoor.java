package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Stag;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceForge;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceWinter;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Utils.StringUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class TheStagDoor extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheStagDoor.class.getSimpleName());

    private static final String IMG_NAME = "waystag_after";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceKnock().DoUpgrade(2),
            new FragmentSecretHistories().DoUpgrade(2),
            new InfluenceForge().DoUpgrade(1)
    };

    private final AbstractCard chosenCard;

    public TheStagDoor() {
        super(ID, IMG_NAME, CARDS);

        int idx = MathUtils.random(CARDS.length - 1);
        this.chosenCard = CARDS[idx].makeStatEquivalentCopy();
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
