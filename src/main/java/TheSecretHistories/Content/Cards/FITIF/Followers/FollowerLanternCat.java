package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Powers.Principles.Lantern;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Iterator;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FollowerLanternCat extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerLanternCat.class.getSimpleName());
    private static final String IMG_NAME = "cat_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = LANTERN;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public FollowerLanternCat() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                if (this.duration == 0.5F) {
                    AbstractDungeon.handCardSelectScreen.open(TEXT[1], 99, true, true);
                    this.addToBot(new WaitAction(0.25F));
                    this.tickDuration();
                } else {
                    if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
                        if (!AbstractDungeon.handCardSelectScreen.selectedCards.group.isEmpty()) {
                            this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new Lantern(AbstractDungeon.player, AbstractDungeon.handCardSelectScreen.selectedCards.group.size())));

                            for (AbstractCard c : AbstractDungeon.handCardSelectScreen.selectedCards.group) {
                                AbstractDungeon.player.hand.moveToDiscardPile(c);
                                GameActionManager.incrementDiscard(false);
                                c.triggerOnManualDiscard();
                            }
                        }

                        AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
                    }

                    this.tickDuration();
                }
            }
        });
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeBaseCost(0);
    }
}