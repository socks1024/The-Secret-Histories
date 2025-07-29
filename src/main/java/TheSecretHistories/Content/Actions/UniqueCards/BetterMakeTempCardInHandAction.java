package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Utils.DebugUtils;
import basemod.BaseMod;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDiscardEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToHandEffect;

public class BetterMakeTempCardInHandAction extends AbstractGameAction {
    private AbstractCard c;

    private static final float PADDING = 25.0F * Settings.scale;

    private boolean isOtherCardInCenter = true;

    private boolean sameUUID = false;

    public BetterMakeTempCardInHandAction(AbstractCard card, boolean isOtherCardInCenter) {
        UnlockTracker.markCardAsSeen(card.cardID);
        this.amount = 1;
        this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
        this.c = card;
        this.isOtherCardInCenter = isOtherCardInCenter;
    }

    public BetterMakeTempCardInHandAction(AbstractCard card) {
        this(card, 1);
    }

    public BetterMakeTempCardInHandAction(AbstractCard card, int amount) {
        UnlockTracker.markCardAsSeen(card.cardID);
        this.amount = amount;
        this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
        this.c = card;
    }

    public BetterMakeTempCardInHandAction(AbstractCard card, int amount, boolean isOtherCardInCenter) {
        this(card, amount);
        this.isOtherCardInCenter = isOtherCardInCenter;
    }

    public BetterMakeTempCardInHandAction(AbstractCard card, boolean isOtherCardInCenter, boolean sameUUID) {
        this(card, 1);
        this.isOtherCardInCenter = isOtherCardInCenter;
        this.sameUUID = sameUUID;
    }

    public void update() {
        if (this.amount == 0) {
            this.isDone = true;
            return;
        }
        int discardAmount = 0;
        int handAmount = this.amount;
        if (this.amount + AbstractDungeon.player.hand.size() > BaseMod.MAX_HAND_SIZE) {
            AbstractDungeon.player.createHandIsFullDialog();
            discardAmount = this.amount + AbstractDungeon.player.hand.size() - BaseMod.MAX_HAND_SIZE;
            handAmount -= discardAmount;
        }
        addToHand(handAmount);
        addToDiscard(discardAmount);
        if (this.amount > 0)
            addToTop(new WaitAction(0.8F));
        this.isDone = true;
    }

    private void addToHand(int handAmt) {
        switch (this.amount) {
            case 0:
                return;
            case 1:
                if (handAmt == 1)
                    if (this.isOtherCardInCenter) {
                        DebugUtils.Log(1);
                        AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(

                                makeNewCard(), Settings.WIDTH / 2.0F - PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT / 2.0F));
                    } else {
                        DebugUtils.Log(2);
                        AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(makeNewCard()));
                    }
                break;
            case 2:
                if (handAmt == 1) {
                    DebugUtils.Log(3);
                    AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(

                            makeNewCard(), Settings.WIDTH / 2.0F - PADDING + AbstractCard.IMG_WIDTH * 0.5F, Settings.HEIGHT / 2.0F));
                } else if (handAmt == 2) {
                    DebugUtils.Log(4);
                    AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(

                            makeNewCard(), Settings.WIDTH / 2.0F + PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT / 2.0F));
                    AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(

                            makeNewCard(), Settings.WIDTH / 2.0F - PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT / 2.0F));
                }
                break;
            case 3:
                if (handAmt == 1) {
                    DebugUtils.Log(5);
                    AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(

                            makeNewCard(), Settings.WIDTH / 2.0F - PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT / 2.0F));
                } else if (handAmt == 2) {
                    DebugUtils.Log(6);
                    AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(

                            makeNewCard(), Settings.WIDTH / 2.0F + PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT / 2.0F));
                    AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(

                            makeNewCard(), Settings.WIDTH / 2.0F - PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT / 2.0F));
                } else if (handAmt == 3) {
                    DebugUtils.Log(7);
                    for (int j = 0; j < this.amount; j++){
                        DebugUtils.Log(j);
                        AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(makeNewCard()));

                    }
                }
                break;
        }
    }

    private void addToDiscard(int discardAmt) {
        switch (this.amount) {
            case 0:
                return;
            case 1:
                if (discardAmt == 1)
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(

                            makeNewCard(), Settings.WIDTH / 2.0F + PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT / 2.0F));
                break;
            case 2:
                if (discardAmt == 1) {
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(

                            makeNewCard(), Settings.WIDTH * 0.5F - PADDING + AbstractCard.IMG_WIDTH * 0.5F, Settings.HEIGHT * 0.5F));
                } else if (discardAmt == 2) {
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(

                            makeNewCard(), Settings.WIDTH * 0.5F - PADDING + AbstractCard.IMG_WIDTH * 0.5F, Settings.HEIGHT * 0.5F));
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(

                            makeNewCard(), Settings.WIDTH * 0.5F + PADDING + AbstractCard.IMG_WIDTH * 0.5F, Settings.HEIGHT * 0.5F));
                }
                break;
            case 3:
                if (discardAmt == 1) {
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(

                            makeNewCard(), Settings.WIDTH * 0.5F + PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT * 0.5F));
                } else if (discardAmt == 2) {
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(

                            makeNewCard(), Settings.WIDTH * 0.5F, Settings.HEIGHT * 0.5F));
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(

                            makeNewCard(), Settings.WIDTH * 0.5F + PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT * 0.5F));
                } else if (discardAmt == 3) {
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(

                            makeNewCard(), Settings.WIDTH * 0.5F, Settings.HEIGHT * 0.5F));
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(

                            makeNewCard(), Settings.WIDTH * 0.5F - PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT * 0.5F));
                    AbstractDungeon.effectList.add(new ShowCardAndAddToDiscardEffect(

                            makeNewCard(), Settings.WIDTH * 0.5F + PADDING + AbstractCard.IMG_WIDTH, Settings.HEIGHT * 0.5F));
                }
                break;
        }
    }

    private AbstractCard makeNewCard() {
        if (this.sameUUID)
            return this.c.makeSameInstanceOf();
        return this.c.makeStatEquivalentCopy();
    }
}
