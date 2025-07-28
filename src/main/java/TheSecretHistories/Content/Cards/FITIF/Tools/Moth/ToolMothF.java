package TheSecretHistories.Content.Cards.FITIF.Tools.Moth;

import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class ToolMothF extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolMothF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = MOTH;

    private static final String IMG_NAME = "toolmothf";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public ToolMothF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.damage = this.baseDamage = 0;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.selfRetain = true;
        super.OnUpgrade(timesUpgraded);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        super.use(p, m);

        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                baseDamage = PowerUtils.GetPowerAmount(Moth.POWER_ID, p);

                calculateDamageDisplay(m);

                addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HEAVY));

                isDone = true;
            }
        });
    }

    @Override
    protected void PreApplyPowers() {
        super.PreApplyPowers();

        this.baseDamage = PowerUtils.GetPowerAmount(Moth.POWER_ID, AbstractDungeon.player);
    }
}
