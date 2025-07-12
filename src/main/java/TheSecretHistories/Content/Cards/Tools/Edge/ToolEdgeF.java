package TheSecretHistories.Content.Cards.Tools.Edge;

import TheSecretHistories.Content.Actions.UniqueCards.ToolEdgeFAction;
import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.UniqueCards.ToolEdgeDPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class ToolEdgeF extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolEdgeF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = EDGE;

    private static final String IMG_NAME = "tooledgef";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;

    public ToolEdgeF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.exhaust = true;

        this.damage = this.baseDamage = 12;
        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ToolEdgeFAction(abstractPlayer, damage, magicNumber));
    }
}
