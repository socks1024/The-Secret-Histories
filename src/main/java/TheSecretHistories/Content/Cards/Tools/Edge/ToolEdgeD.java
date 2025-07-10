package TheSecretHistories.Content.Cards.Tools.Edge;

import TheSecretHistories.Content.Actions.UniqueCards.ToolEdgeBAction;
import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.UniqueCards.ToolEdgeDPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class ToolEdgeD extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolEdgeD.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = EDGE;

    private static final String IMG_NAME = "tooledged";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public ToolEdgeD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.damage = this.baseDamage = 13;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeDamage(4);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new ToolEdgeDPower(abstractPlayer, 1)));
    }
}
