package TheSecretHistories.Content.Cards.Tools.Winter;

import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class ToolWinterB extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolWinterB.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = WINTER;

    private static final String IMG_NAME = "toolwinterb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;

    public ToolWinterB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.magicNumber = this.baseMagicNumber = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);


    }
}
