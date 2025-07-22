package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Wood;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceMoth;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Others.Rumour;
import TheSecretHistories.Utils.StringUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.watcher.MasterRealityPower;

public class TheWood extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheWood.class.getSimpleName());

    private static final String IMG_NAME = "waywood";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceMoth(),
            new FragmentSecretHistories(),
            new Rumour(),
    };

    private final AbstractCard chosenCard;

    public TheWood() {
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

//    @Override
//    public void onChoseThisOption() {
//        AbstractDungeon.actionManager.addToBottom(
//                new MakeTempCardInHandAction(chosenCard.makeStatEquivalentCopy())
//        );
//    }
    @Override
    public void onChoseThisOption() {

        MasterRealityPower mrPower = null;
        if (AbstractDungeon.player.hasPower(MasterRealityPower.POWER_ID)) {
            mrPower = (MasterRealityPower) AbstractDungeon.player.getPower(MasterRealityPower.POWER_ID);
            AbstractDungeon.player.powers.remove(mrPower);
            chosenCard.upgrade();
        }

        AbstractDungeon.actionManager.addToBottom(
                new MakeTempCardInHandAction(chosenCard.makeStatEquivalentCopy(), 1)
        );

        if (mrPower != null) {
            AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(
                    AbstractDungeon.player,
                    AbstractDungeon.player,
                    new MasterRealityPower(AbstractDungeon.player)
            ));
        }
    }

}

