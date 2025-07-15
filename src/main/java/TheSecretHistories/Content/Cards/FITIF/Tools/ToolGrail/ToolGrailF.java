package TheSecretHistories.Content.Cards.FITIF.Tools.ToolGrail;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.ToolGrailFAction;
import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class ToolGrailF extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolGrailF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = GRAIL;

    private static final String IMG_NAME = "toolgrailf";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public ToolGrailF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.magicNumber = this.baseMagicNumber = 4;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(-1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ToolGrailFAction(abstractMonster, abstractPlayer, PRINCIPLE_TAG, magicNumber));
    }
}
