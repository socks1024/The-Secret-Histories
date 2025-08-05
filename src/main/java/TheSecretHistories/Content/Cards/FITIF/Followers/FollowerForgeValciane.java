package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.GrailFAction2;
import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class FollowerForgeValciane extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerForgeValciane.class.getSimpleName());

    private static final String IMG_NAME = "valciane_a";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = FORGE;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public FollowerForgeValciane() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.damage = this.baseDamage = 0;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);

        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                int count = p.hand.size();

                for (int i = count - 1; i >= 0; i--){
                    AbstractCard card = AbstractDungeon.player.hand.group.get(i);

                    if (card instanceof TemplateCustomCard)
                        addToTop(new DamageAction(m, new DamageInfo(p, damage + ((TemplateCustomCard)card).principleCount), AbstractGameAction.AttackEffect.FIRE));

                    if (Settings.FAST_MODE) {
                        addToTop(new ExhaustSpecificCardAction(card, AbstractDungeon.player.hand, true));
                    } else {
                        addToTop(new ExhaustSpecificCardAction(card, AbstractDungeon.player.hand, false));
                    }
                }

                this.isDone = true;
            }
        });
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeBaseCost(1);
    }
}
