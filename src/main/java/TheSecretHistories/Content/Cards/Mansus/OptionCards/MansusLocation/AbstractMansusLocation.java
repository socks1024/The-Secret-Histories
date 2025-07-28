package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation;

import TheSecretHistories.Content.Actions.UniqueCards.ChooseAndAddToHandAction;
import TheSecretHistories.Content.Cards.Template.TemplateOptionCard;
import TheSecretHistories.Content.Powers.UniqueCards.FollowerKnockNPower;
import TheSecretHistories.Content.Powers.UniqueCards.MansusChooseCardPower;
import TheSecretHistories.Content.Powers.UniqueCards.ToolSecretHistoriesDPower;
import TheSecretHistories.Utils.DebugUtils;
import TheSecretHistories.Utils.PowerUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public abstract class AbstractMansusLocation extends TemplateOptionCard {

    private static final CardColor COLOR = CULT_BLUE;

    protected AbstractCard[] cards;

    protected static Map<String, ArrayList<AbstractCard>> pools = new HashMap<>();

    protected void InitializePool() {

        if (!pools.containsKey(cardID)) pools.put(cardID, new ArrayList<>());

        pools.get(cardID).clear();

        for (AbstractCard card : cards) {
            pools.get(cardID).add(card.makeStatEquivalentCopy());
        }
    }

    protected AbstractCard GetRandomCardFromPool() {
        if (!pools.containsKey(cardID) || pools.get(cardID).isEmpty()) InitializePool();

        ArrayList<AbstractCard> pool = pools.get(cardID);

        DebugUtils.Log(pool);

        return pool.get(new Random().nextInt(pool.size()));
    }

    protected ArrayList<AbstractCard> GetCards() {
        ArrayList<AbstractCard> retCards = new ArrayList<>();

        for (AbstractCard card : cards) {
            retCards.add(card.makeStatEquivalentCopy());
        }

        return retCards;
    }

    protected AbstractCard chosenCard;

    public AbstractMansusLocation(String id, String imgName, AbstractCard[] cards) {
        super(id, imgName, COLOR);
        this.cards = cards;

        chosenCard = GetRandomCardFromPool();
    }

    @Override
    public void onChoseThisOption() {

        AbstractPlayer p = AbstractDungeon.player;

        if (p.hasPower(MansusChooseCardPower.POWER_ID)) {

            addToTop(new ChooseAndAddToHandAction(GetCards()));

            p.getPower(MansusChooseCardPower.POWER_ID).amount -= 1;
            if (p.getPower(MansusChooseCardPower.POWER_ID).amount <= 0) {
                addToTop(new RemoveSpecificPowerAction(p,p,MansusChooseCardPower.POWER_ID));
            }

        } else {

            pools.get(cardID).remove(chosenCard);

            DebugUtils.Log(pools.get(cardID));

            AbstractCard card = chosenCard.makeStatEquivalentCopy();

            if (p.hasPower(ToolSecretHistoriesDPower.POWER_ID) && card.hasTag(SECRET_HISTORIES)) {
                for (int i = 0; i < p.getPower(ToolSecretHistoriesDPower.POWER_ID).amount; i++) {
                    card.upgrade();
                }
            }

            if (p.hasPower(FollowerKnockNPower.POWER_ID)) {
                addToTop(new DamageRandomEnemyAction(new DamageInfo(p ,PowerUtils.GetPowerAmount(FollowerKnockNPower.POWER_ID, p)), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
            }

            addToTop(new MakeTempCardInHandAction(card));

        }
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }
}
