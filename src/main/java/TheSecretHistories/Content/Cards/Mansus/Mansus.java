package TheSecretHistories.Content.Cards.Mansus;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay.*;
import TheSecretHistories.Content.Cards.Template.TemplateMultiLevelCard;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;

public class Mansus extends TemplateMultiLevelCard {

    public static final String ID = StringUtils.MakeID(Mansus.class.getSimpleName());

    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.NONE;

    public Mansus() {
        super(ID, COST, TYPE, COLOR, RARITY, TARGET, 4);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

        addToBot(new ChooseOneAction(GetAvailableWays()));
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = super.canUse(p, m);
        if (!canUse) return false;

        return !GetAvailableWays().isEmpty();
    }

    private ArrayList<AbstractCard> GetAvailableWays() {

        ArrayList<AbstractCard> ways = new ArrayList<>();

        TryAddWay(new WayWood(), ways);
        TryAddWay(new WayWhite(), ways);
        TryAddWay(new WayStag(), ways);
        TryAddWay(new WaySpider(), ways);
        TryAddWay(new WayPeacock(), ways);

        return ways;

    }

    private void TryAddWay(AbstractMansusWay way, ArrayList<AbstractCard> ways) {
        if (way.GetAvailable()) ways.add(way.makeStatEquivalentCopy());
    }

    public void onRemoveFromMasterDeck() {
        AbstractDungeon.player.masterDeck.addToHand(makeStatEquivalentCopy());
    }

    public void triggerOnExhaust() {
        addToBot(new MakeTempCardInHandAction(makeStatEquivalentCopy()));
    }
}
