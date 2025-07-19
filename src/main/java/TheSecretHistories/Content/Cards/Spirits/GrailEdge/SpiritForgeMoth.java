package TheSecretHistories.Content.Cards.Spirits.GrailEdge;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientMothFToWinterAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Content.Powers.UniqueCards.Spirit_ForgeC_WinterPower;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DarkEmbracePower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritForgeMoth extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritForgeMoth.class.getSimpleName());
    private static final String IMG_NAME = "spirit_forgec_winter";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(FORGE, 12),
            new PrincipleUtils.ReducePrincipleInfo(WINTER, 4),
    };

    public SpiritForgeMoth() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.damage = this.baseDamage=14;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage)));
        addToBot(new ApplyPowerAction(p, p, new Spirit_ForgeC_WinterPower(p, 1,timesUpgraded), 1));

    }

    @Override
    public void OnUpgrade(int timesUpgraded) {
        upgradeDamage(3);
    }

}
