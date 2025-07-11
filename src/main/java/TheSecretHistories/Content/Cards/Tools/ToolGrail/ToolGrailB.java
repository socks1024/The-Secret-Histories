package TheSecretHistories.Content.Cards.Tools.ToolGrail;

import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.HeatsinkPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class ToolGrailB extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolGrailB.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = GRAIL;

    private static final String IMG_NAME = "toolgrailb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public ToolGrailB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.magicNumber = this.baseMagicNumber = 1;
        this.damage = this.baseDamage = 12;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeDamage(5);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new DamageAction(abstractMonster, new DamageInfo(abstractPlayer, damage)));
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new VulnerablePower(abstractPlayer, magicNumber, false)));
    }
}
