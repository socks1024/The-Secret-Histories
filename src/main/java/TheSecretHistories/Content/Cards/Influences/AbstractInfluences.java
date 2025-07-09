package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Template.TemplateMultiLevelCard;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FRAGMENT;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.INFLUENCE;

public abstract class AbstractInfluences extends TemplateMultiLevelCard {

    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.SELF;

    public AbstractInfluences(String id, CardTags principleTag) {
        super(id, COST, TYPE, COLOR, RARITY, TARGET, 3);

        this.tags.add(INFLUENCE);
        this.tags.add(principleTag);

        this.exhaust = true;
        this.isEthereal = true;

        this.upgradeTimesLimit = 3;

        this.magicNumber = this.baseMagicNumber = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(GetMagicNumberIncrease(timesUpgraded));
    }

    private int GetMagicNumberIncrease(int timesUpgraded)
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
}
