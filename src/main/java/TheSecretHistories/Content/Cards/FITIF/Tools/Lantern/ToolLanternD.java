package TheSecretHistories.Content.Cards.FITIF.Tools.Lantern;

import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.unique.GamblingChipAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class ToolLanternD extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolLanternD.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = LANTERN;

    private static final String IMG_NAME = "toollanternd";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    public ToolLanternD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.exhaust = true;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.isInnate = true;
        super.OnUpgrade(timesUpgraded);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new GamblingChipAction(AbstractDungeon.player, true));
    }
}
