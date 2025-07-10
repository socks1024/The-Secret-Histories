package TheSecretHistories.Content.Cards.Tools.Lantern;

import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.UniqueCards.ToolLanternFPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class ToolLanternF extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolLanternF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = LANTERN;

    private static final String IMG_NAME = "toollanternf";
    private static final int COST = 3;
    private static final CardType TYPE = CardType.POWER;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;

    public ToolLanternF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.isEthereal = true;

        this.magicNumber = this.baseMagicNumber = 3;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.upgradeMagicNumber(-1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer,new ToolLanternFPower(abstractPlayer, magicNumber)));
    }
}
