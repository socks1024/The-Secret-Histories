package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation;

import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.cards.AbstractCard;

public abstract class AbstractHiddenLocation extends AbstractMansusLocation {
    public AbstractHiddenLocation(String id, String imgName, AbstractCard[] cards) {
        super(id, imgName, cards);
    }

    private float rotationTimer = 0f;
    private int previewIndex = 0;

    @Override
    public void update() {
        super.update();
        if (this.hb.hovered) {
            if (this.rotationTimer <= 0f) {
                this.rotationTimer = 1f;
                this.cardsToPreview = cards[previewIndex].makeStatEquivalentCopy();
                previewIndex = (previewIndex + 1) % cards.length;
            } else {
                this.rotationTimer -= Gdx.graphics.getDeltaTime();
            }
        }
    }
}
