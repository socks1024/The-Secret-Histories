package TheSecretHistories.Content.Cards.Tools.Heart;

import TheSecretHistories.Content.Actions.UniqueCards.DecreaseMaxHpAction;
import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class ToolHeartF extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolHeartF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = HEART;

    private static final String IMG_NAME = "toolheartf";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;

    private static final int HEAL_AMOUNT = 10;

    public ToolHeartF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.isEthereal = true;

        this.magicNumber = this.baseMagicNumber = 3;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(-1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new HealAction(abstractPlayer, abstractPlayer, HEAL_AMOUNT));
        addToBot(new DecreaseMaxHpAction(abstractPlayer, magicNumber));
    }
}
