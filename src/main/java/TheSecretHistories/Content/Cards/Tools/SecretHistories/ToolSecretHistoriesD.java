package TheSecretHistories.Content.Cards.Tools.SecretHistories;

import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class ToolSecretHistoriesD extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolSecretHistoriesD.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = MOTH;

    private static final String IMG_NAME = "toolsecrethistoriesb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.POWER;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public ToolSecretHistoriesD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.principleCount = this.basePrincipleCount = 8;

        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.isInnate = true;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);


    }
}
