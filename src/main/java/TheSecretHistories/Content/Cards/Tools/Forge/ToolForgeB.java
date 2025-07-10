package TheSecretHistories.Content.Cards.Tools.Forge;

import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.UniqueCards.ToolForgeBPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class ToolForgeB extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolForgeB.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = FORGE;

    private static final String IMG_NAME = "toolforgeb";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.POWER;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    public ToolForgeB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.magicNumber = this.baseMagicNumber = 10;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(-4);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new ToolForgeBPower(abstractPlayer, magicNumber)));
    }
}
