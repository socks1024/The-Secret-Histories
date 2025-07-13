package TheSecretHistories.Content.Cards.FITIF.Influences;

import TheSecretHistories.Content.Cards.Template.TemplateMultiLevelCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.INFLUENCE;

public abstract class AbstractInfluences extends TemplateMultiLevelCard {

    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.SELF;

    private static final int UPGRADE_TIMES_LIMIT = 3;

    public AbstractInfluences(String id, CardTags principleTag) {
        super(id, COST, TYPE, COLOR, RARITY, TARGET, UPGRADE_TIMES_LIMIT);

        this.tags.add(INFLUENCE);
        this.tags.add(principleTag);

        this.principleTag = principleTag;

        this.exhaust = true;
        this.isEthereal = true;

        this.principleCount = this.basePrincipleCount = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradePrincipleCount(GetPrincipleIncrease(timesUpgraded));
    }

    private int GetPrincipleIncrease(int timesUpgraded)
    {
        // 2 6 10 15
        // 2 + 4 = 6
        // 6 + 4 = 10
        // 10 + 5 = 15
        switch (timesUpgraded){
            case 0:
            case 1:
                return 4;
            case 2:
                return 5;
        }

        return 0;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple();
    }
}
