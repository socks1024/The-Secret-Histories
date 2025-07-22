package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Spider;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceForge;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Others.Favour;
import TheSecretHistories.Utils.StringUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class TheSpiderDoor extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheSpiderDoor.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceGrail().DoUpgrade(2),
            new InfluenceHeart().DoUpgrade(2),
            new FragmentSecretHistories().DoUpgrade(3),
            new Favour(),
    };

    private final AbstractCard chosenCard;

    public TheSpiderDoor() {
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