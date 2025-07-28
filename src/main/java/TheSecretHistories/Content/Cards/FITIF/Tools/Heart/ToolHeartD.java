package TheSecretHistories.Content.Cards.FITIF.Tools.Heart;

import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class ToolHeartD extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolHeartD.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = HEART;

    private static final String IMG_NAME = "toolheartd";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    public ToolHeartD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.block = this.baseBlock = 5;
        this.magicNumber = this.baseMagicNumber = 1;
        // this.isInnate = true;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
        super.OnUpgrade(timesUpgraded);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new GainBlockAction(abstractPlayer, block));
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new BlurPower(abstractPlayer, magicNumber)));
    }
}
