package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientEdgeFPrincipleAction;
import TheSecretHistories.Content.Powers.Principles.*;
import TheSecretHistories.Content.Powers.UniqueCards.ToolEdgeDPower;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;
public class FollowerMothSylvia extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerMothSylvia.class.getSimpleName());
    private static final String IMG_NAME = "sylvia_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    public static CardTags PRINCIPLE_TAG = MOTH;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    public FollowerMothSylvia() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.damage = this.baseDamage = 9;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new DamageAction(m, new DamageInfo(p, damage)));

        String[] principleIDs = new String[] {
                Winter.POWER_ID,
                Heart.POWER_ID,
                Lantern.POWER_ID,
                Edge.POWER_ID,
                Knock.POWER_ID,
                Grail.POWER_ID,
                SecretHistories.POWER_ID,
                Forge.POWER_ID,

        };
        String minPrinciple = null;
        int minAmount = Integer.MAX_VALUE;
        for (String pid : principleIDs) {
            if (pid.equals(Moth.POWER_ID)) continue; // 不考虑自己
            int amount = PowerUtils.GetPowerAmount(pid, p);
            if (amount > 0 && amount < minAmount) {
                minPrinciple = pid;
                minAmount = amount;
            }
        }
        if (minPrinciple != null) {
            addToBot(new ReducePowerAction(p, p, minPrinciple, minAmount));
            addToBot(new ApplyPowerAction(p, p, new Moth(p, 1), minAmount));
        }

    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeDamage(3);
    }
}