package TheSecretHistories.Content.Cards.FITIF.Tools.Edge;

import TheSecretHistories.Content.Actions.UniqueCards.ToolEdgeBAction;
import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class ToolEdgeB extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolEdgeB.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = EDGE;

    private static final String IMG_NAME = "tooledgeb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    private static final int STRENGTH_AMOUNT = 1;

    public ToolEdgeB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.magicNumber = this.baseMagicNumber = 3;
        this.damage = this.baseDamage = 3;

        this.exhaust = true;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        for (int i = 0; i < magicNumber; i++) {
            addToBot(new ToolEdgeBAction(abstractMonster, abstractPlayer, new DamageInfo(abstractPlayer, damage), STRENGTH_AMOUNT));
        }
    }
}
