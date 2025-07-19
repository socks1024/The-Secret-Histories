package TheSecretHistories.Content.Cards.Others.Illness;

import TheSecretHistories.Content.Cards.Others.TemplateCustomStatusCard;
import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Affliction extends TemplateCustomStatusCard {

    public static final String ID = StringUtils.MakeID(Affliction.class.getSimpleName());

    private static final String IMG_NAME = "affliction";

    public Affliction() {
        super(ID, IMG_NAME);

        this.baseMagicNumber = this.magicNumber = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (this.dontTriggerOnUseCard)
            addToBot(new DamageAction(AbstractDungeon.player, new DamageInfo(AbstractDungeon.player, this.magicNumber, DamageInfo.DamageType.THORNS)));
    }

    public void triggerOnEndOfTurnForPlayingCard() {
        this.dontTriggerOnUseCard = true;
        AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(this, true));
    }
}
