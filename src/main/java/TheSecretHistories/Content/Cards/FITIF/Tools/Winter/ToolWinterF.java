package TheSecretHistories.Content.Cards.FITIF.Tools.Winter;

import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Content.Powers.UniqueCards.ToolWinterFEntanglePower;
import TheSecretHistories.Content.Powers.UniqueCards.ToolWinterFPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class ToolWinterF extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolWinterF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = WINTER;

    private static final String IMG_NAME = "toolwinterf";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public ToolWinterF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.magicNumber = this.baseMagicNumber = 8;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(4);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ApplyPowerAction(abstractMonster, abstractPlayer, new Winter(abstractMonster, magicNumber)));
        addToBot(new ApplyPowerAction(abstractMonster, abstractPlayer, new ToolWinterFPower(abstractMonster)));
    }
}
