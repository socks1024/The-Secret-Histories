package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FOLLOWER;

public abstract class AbstractFollower extends TemplateCustomCard {

    private static final CardColor COLOR = CULT_BLUE;

    public AbstractFollower(String id, String imgName, int cost, CardType type, CardRarity rarity, CardTarget target, CardTags principleTag) {
        super(id, imgName, cost, type, COLOR, rarity, target);

        this.principleCount = this.basePrincipleCount = 5;

        this.principleTag = principleTag;

        this.tags.add(principleTag);
        this.tags.add(FOLLOWER);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradePrincipleCount(5);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple();
    }
}
