package TheSecretHistories.Content.Cards.FITIF.Tools.Knock;

import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.UniqueCards.ToolKnockFPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class ToolKnockF extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolKnockF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = KNOCK;

    private static final String IMG_NAME = "toolknockf";
    private static final int COST = 3;
    private static final CardType TYPE = CardType.POWER;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;

    public ToolKnockF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.isEthereal = true;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.isEthereal = false;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new ToolKnockFPower(abstractPlayer)));
    }
}
