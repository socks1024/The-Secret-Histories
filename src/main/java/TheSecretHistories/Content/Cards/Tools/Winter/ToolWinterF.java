package TheSecretHistories.Content.Cards.Tools.Winter;

import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.UniqueCards.SuperEntangle;
import TheSecretHistories.Content.Powers.UniqueCards.ToolWinterDPower;
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
    private static final int COST = 3;
    private static final CardType TYPE = CardType.POWER;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;

    public ToolWinterF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeBaseCost(2);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new ToolWinterFPower(abstractPlayer)));

        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new SuperEntangle(abstractPlayer)));
    }
}
