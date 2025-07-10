package TheSecretHistories.Content.Cards.Tools.Forge;

import TheSecretHistories.Content.Actions.UniqueCards.UpgradeByPrincipleAction;
import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.TOOL;

public class ToolForgeD extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolForgeD.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = FORGE;

    private static final String IMG_NAME = "toolforged";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public ToolForgeD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.damage = this.baseDamage = 8;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeDamage(3);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new DamageAction(abstractMonster, new DamageInfo(abstractPlayer, damage)));
        addToBot(new UpgradeByPrincipleAction(abstractPlayer, TOOL));
    }
}
