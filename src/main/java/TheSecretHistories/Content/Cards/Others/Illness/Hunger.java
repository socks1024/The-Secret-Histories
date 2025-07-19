package TheSecretHistories.Content.Cards.Others.Illness;

import TheSecretHistories.Content.Actions.UniqueCards.LoseGoldAction;
import TheSecretHistories.Content.Cards.Others.TemplateCustomStatusCard;
import TheSecretHistories.Utils.LambdaUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Hunger extends TemplateCustomStatusCard {

    public static final String ID = StringUtils.MakeID(Hunger.class.getSimpleName());

    private static final String IMG_NAME = "hunger";

    public Hunger() {
        super(ID, IMG_NAME);

        this.baseMagicNumber = this.magicNumber = 10;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (this.dontTriggerOnUseCard) addToBot(new LoseGoldAction(magicNumber));
    }

    public void triggerOnEndOfTurnForPlayingCard() {
        this.dontTriggerOnUseCard = true;
        AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(this, true));
    }
}
