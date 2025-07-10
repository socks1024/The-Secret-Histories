package TheSecretHistories.Content.Cards.Tools.Forge;

import TheSecretHistories.Content.Actions.UniqueCards.UpgradeAllByPrincipleAction;
import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class ToolForgeF extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolForgeF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = FORGE;

    private static final String IMG_NAME = "toolforgef";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public ToolForgeF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.magicNumber = this.baseMagicNumber = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(2);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        for (int i = 0; i < magicNumber; i++) {

            addToBot(new UpgradeAllByPrincipleAction(abstractPlayer, FRAGMENT));

        }
    }
}
