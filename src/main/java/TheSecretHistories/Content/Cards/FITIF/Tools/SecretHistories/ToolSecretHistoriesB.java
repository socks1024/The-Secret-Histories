package TheSecretHistories.Content.Cards.FITIF.Tools.SecretHistories;

import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.UniqueCards.ToolSecretHistoriesBPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.EnergyDownPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public class ToolSecretHistoriesB extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolSecretHistoriesB.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = SECRET_HISTORIES;

    private static final String IMG_NAME = "toolsecrethistoriesb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.NONE;

    public ToolSecretHistoriesB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.principleCount = this.basePrincipleCount = 4;

        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeBaseCost(0);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new ToolSecretHistoriesBPower(abstractPlayer, magicNumber)));
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new EnergyDownPower(abstractPlayer, magicNumber)));
    }
}
